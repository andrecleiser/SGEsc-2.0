package com.hcdev.sgesc.api.evento.ouvinte;

import java.net.URI;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hcdev.sgesc.api.evento.RecursoCriadoEvento;

@Component
public class RecursoCriadoOuvinte implements ApplicationListener<RecursoCriadoEvento> {

	@Override
	public void onApplicationEvent(RecursoCriadoEvento recursoCriadoEvento) {
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri()
				.path("/{id}")
				.buildAndExpand(recursoCriadoEvento.getIdEntidade())
				.toUri();
		
		recursoCriadoEvento.getResponse().setHeader("Location", uri.toASCIIString());
		
	}

}
