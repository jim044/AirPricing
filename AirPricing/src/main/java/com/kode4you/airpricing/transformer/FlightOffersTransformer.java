package com.kode4you.airpricing.transformer;

import com.kode4you.airpricing.domain.request.*;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.AbstractTransformer;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightOffersTransformer extends AbstractTransformer {

    @Override
    protected Object doTransform(Message<?> message) {
        FlightOffersRequest flightOffersRequest = new FlightOffersRequest();
        flightOffersRequest.setCurrencyCode("USD");
        List<String> sourceList = new ArrayList<>();
        sourceList.add("GDS");
        flightOffersRequest.setSources(sourceList);
        TravelersRequest travelersRequest = new TravelersRequest();
        travelersRequest.setId("1");
        travelersRequest.setTravelerType("ADULT");
        List<TravelersRequest> travelersRequestList = new ArrayList<>();
        travelersRequestList.add(travelersRequest);
        flightOffersRequest.setTravelers(travelersRequestList);
        OriginDestinationsRequest originDestinationsRequest = new OriginDestinationsRequest();
        originDestinationsRequest.setId("1");
        originDestinationsRequest.setDestinationLocationCode("MAD");
        originDestinationsRequest.setOriginLocationCode("NYC");
        DepartureDateTimeRangeRequest departureDateTimeRangeRequest = new DepartureDateTimeRangeRequest();
        departureDateTimeRangeRequest.setDate("2023-11-01");
        departureDateTimeRangeRequest.setTime("10:00:00");
        originDestinationsRequest.setDepartureDateTimeRange(departureDateTimeRangeRequest);
        List<OriginDestinationsRequest> originDestinationsRequestList = new ArrayList<>();
        originDestinationsRequestList.add(originDestinationsRequest);
        flightOffersRequest.setOriginDestinations(originDestinationsRequestList);
        SearchCriteriaRequest searchCriteriaRequest = new SearchCriteriaRequest();
        FlightFiltersRequest flightFilters = new FlightFiltersRequest();
        CabinRestrictionsRequest cabinRestrictionsRequest = new CabinRestrictionsRequest();
        List<String> originDestinationIdsList = new ArrayList<>();
        originDestinationIdsList.add("1");
        cabinRestrictionsRequest.setCabin("BUSINESS");
        cabinRestrictionsRequest.setCoverage("MOST_SEGMENTS");
        cabinRestrictionsRequest.setOriginDestinationIds(originDestinationIdsList);
        List<CabinRestrictionsRequest> cabinRestrictionsRequestList = new ArrayList<>();
        cabinRestrictionsRequestList.add(cabinRestrictionsRequest);
        flightFilters.setCabinRestrictions(cabinRestrictionsRequestList);
        searchCriteriaRequest.setFlightFilters(flightFilters);
        searchCriteriaRequest.setMaxFlightOffers(1);
        flightOffersRequest.setSearchCriteria(searchCriteriaRequest);
        return MessageBuilder.withPayload(flightOffersRequest)
                .copyHeaders(message.getHeaders())
                .build();
    }
}
