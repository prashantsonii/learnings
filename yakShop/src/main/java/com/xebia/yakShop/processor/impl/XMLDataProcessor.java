package com.xebia.yakShop.processor.impl;

import static com.xebia.yakShop.constants.XMLNodeAttributeNames.AGE;
import static com.xebia.yakShop.constants.XMLNodeAttributeNames.LABYAK;
import static com.xebia.yakShop.constants.XMLNodeAttributeNames.NAME;
import static com.xebia.yakShop.constants.XMLNodeAttributeNames.SEX;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.xebia.yakShop.constants.Constants;
import com.xebia.yakShop.constants.Gender;
import com.xebia.yakShop.exception.YakShopException;
import com.xebia.yakShop.model.Herd;
import com.xebia.yakShop.model.Yak;
import com.xebia.yakShop.processor.DataProcessor;
import com.xebia.yakShop.validator.Validator;
import com.xebia.yakShop.validator.impl.DataValidator;

/**
 * Implementation of DataProcessor interface to parse the XMA data and convert
 * it to Herd
 */
public class XMLDataProcessor implements DataProcessor {

    private Validator validator = new DataValidator();

    @Override
    public Herd convertYakDataToHerd(File xmlFile) throws YakShopException {
        Herd herd = new Herd();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xmlFile));
            while (xmlEventReader.hasNext()) {
                XMLEvent event = xmlEventReader.nextEvent();
                if(XMLEvent.START_ELEMENT == event.getEventType()){
                    StartElement startElement = (StartElement) event;
                    processStartElement(startElement, herd);
                }
            }

        } catch (FileNotFoundException e) {
            throw createYakShopException(e);
        } catch (XMLStreamException e) {
            throw createYakShopException(e);
        }
        return herd;
    }

    private void processStartElement(StartElement startElement, Herd herd) throws YakShopException {
        if (LABYAK.equalsIgnoreCase(startElement.getName().toString())) {
            Yak yak = new Yak();
            @SuppressWarnings("unchecked")
            Iterator<Attribute> attributes = startElement.getAttributes();
            while (attributes.hasNext()) {
                Attribute attribute = (Attribute) attributes.next();
                String attributeName = attribute.getName().toString();
                String attributeValue = attribute.getValue();
                if (NAME.equalsIgnoreCase(attributeName)) {
                    yak.setYakName(attributeValue);
                } else if (AGE.equalsIgnoreCase(attributeName)) {
                    yak.setAgeInDays((int) (Double.valueOf(attributeValue) * Constants.DAYS_IN_YAK_YEAR));
                } else if (SEX.equalsIgnoreCase(attributeName)) {
                    yak.setGender(Gender.valueOf(attributeValue.toUpperCase()));
                }
            }
            validator.validateYak(yak);
            herd.addYak(yak);
        }
    }

    private YakShopException createYakShopException(Exception exception) {
        YakShopException yakShopException = new YakShopException(exception);
        return yakShopException;
    }
}
