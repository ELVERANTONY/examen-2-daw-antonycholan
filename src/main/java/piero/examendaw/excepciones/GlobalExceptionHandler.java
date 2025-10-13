package piero.examendaw.excepciones;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import piero.examendaw.errors.EspecialidadError;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EspecialidadError.class)
    public ModelAndView handleEspecialidadError(EspecialidadError e){
        ModelAndView model = new ModelAndView();
        model.addObject("titulo", "Recurso no encontrado");
        model.addObject("mensaje", e.getMessage());
        model.addObject("codigo", 404);
        return model;
    }
}
