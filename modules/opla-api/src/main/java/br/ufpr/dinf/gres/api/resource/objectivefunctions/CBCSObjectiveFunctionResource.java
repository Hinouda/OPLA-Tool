package br.ufpr.dinf.gres.api.resource.objectivefunctions;

import br.ufpr.dinf.gres.domain.entity.objectivefunctions.CBCSObjectiveFunction;
import br.ufpr.dinf.gres.api.base.BaseResource;
import br.ufpr.dinf.gres.persistence.base.BaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rcc-objective-function")
public class CBCSObjectiveFunctionResource extends BaseResource<CBCSObjectiveFunction> {

    public CBCSObjectiveFunctionResource(BaseService<CBCSObjectiveFunction> service) {
        super(service);
    }
}