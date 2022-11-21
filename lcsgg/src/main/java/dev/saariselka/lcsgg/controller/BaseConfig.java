package dev.saariselka.lcsgg.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseConfig {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    protected ModelMapper modelMapper = new ModelMapper();
}
