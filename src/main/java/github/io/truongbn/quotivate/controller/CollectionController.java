package github.io.truongbn.quotivate.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import github.io.truongbn.quotivate.core.BackgroundImgConstants;
import github.io.truongbn.quotivate.core.RecordConstants;
import github.io.truongbn.quotivate.model.Collection;
import github.io.truongbn.quotivate.model.Quote;
import github.io.truongbn.quotivate.service.CollectionService;
import github.io.truongbn.quotivate.service.QuoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/collections")
@RequiredArgsConstructor
public class CollectionController {
    private final CollectionService collectionService;
    private final QuoteService quoteService;
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView collections(ModelAndView modelAndView) {
        List<Collection> collections = collectionService.getCollectionsByPage(
                RecordConstants.DEFAULT_PAGE, RecordConstants.DEFAULT_RECORD_PER_PAGE);
        modelAndView.addObject("subjectName", "Collections");
        modelAndView.addObject("backgroundImageURL",
                BackgroundImgConstants.COLLECTION_PAGE_BACKGROUND);
        modelAndView.addObject("collections", collections);
        modelAndView.setViewName("collections/collections");
        return modelAndView;
    }

    @RequestMapping(value = "/{collectionName}", method = RequestMethod.GET)
    public ModelAndView individualCollection(@PathVariable("collectionName") String collectionName,
            ModelAndView modelAndView, HttpServletRequest request) {
        String collectionLink = request.getRequestURI().substring(1);
        List<Object[]> objects = collectionService.getNameAndImageByLink(collectionLink);
        String subjectName = objects.get(0)[0].toString();
        String backgroundImageURL = objects.get(0)[1].toString();
        List<Quote> quotes = quoteService.getByCollectionLink(collectionLink,
                RecordConstants.DEFAULT_PAGE, RecordConstants.DEFAULT_RECORD_PER_PAGE);
        modelAndView.addObject("subjectName", subjectName);
        modelAndView.addObject("backgroundImageURL", backgroundImageURL);
        modelAndView.addObject("quotes", quotes);
        modelAndView.setViewName("collections/individual-collection");
        return modelAndView;
    }
}
