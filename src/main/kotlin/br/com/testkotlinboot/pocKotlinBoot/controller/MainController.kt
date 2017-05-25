package br.com.testkotlinboot.pocKotlinBoot.controller

import br.com.testkotlinboot.pocKotlinBoot.entity.City
import br.com.testkotlinboot.pocKotlinBoot.service.MainControllerService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController



/**
 * Created by hllink on 5/25/17.
 */

@RestController
class MainController(val service:MainControllerService) {

    @RequestMapping(value = "/rest/cities",  produces = arrayOf("application/json"))
    @ResponseBody
    fun citiesRest(@RequestParam(value = "country", required = false) countryQuery: String?): List<City>? {
        return if (countryQuery != null)  service.findByCountryName(countryQuery) else service.findAll()
    }

    @RequestMapping(value = "/rest/cities/add", produces = arrayOf("application/json"))
    @ResponseBody
    fun addCityRest(@RequestParam(value = "city", required = true) city: String,
                    @RequestParam(value = "country", required = true) country: String): String {
        return service.addCity(city, country)
    }
}