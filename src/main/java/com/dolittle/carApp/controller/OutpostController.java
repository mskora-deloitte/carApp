package com.dolittle.carApp.controller;

import com.dolittle.carApp.model.Employee;
import com.dolittle.carApp.model.Outpost;
import com.dolittle.carApp.service.OutpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class OutpostController {

    @Autowired
    OutpostService outpostService;

    @PostMapping("/outposts")
    public Outpost addOutpost(@RequestBody Outpost request) {
        return outpostService.addOutpost(request);
    }

    @DeleteMapping("/outposts")
    public String deleteOutpost(@RequestParam Long id) {
        return outpostService.deleteOutpost(id) ? "Successfully deleted outpost" : "No outpost with such ID";
    }

    @PatchMapping("/outposts")
    public String patchOutpost(@RequestBody Outpost request) {
        return outpostService.patchOutpost(request) ? "Successfully patched outpost" : "No outpost with such ID";
    }

    @PatchMapping("/outposts/{outpostId}/employees")
    public String addEmployeeToOutpost(@PathVariable Long outpostId, @RequestParam Long employeeId) {
        return outpostService.addEmployeeToOutpost(outpostId, employeeId) ?
                "Successfully added employee to given outpost"
                :
                "Something went wrong";
    }

    @GetMapping("/outposts/{id}/employees")
    public Set<Employee> getOutpostEmployees(@PathVariable Long id) {
        return outpostService.getOutpostEmployees(id);
    }

    @GetMapping("/outposts/{outpostId}/maintainers")
    public Set<Employee> getOutpostCarMaintainers(@PathVariable Long outpostId, @RequestParam Long carId) {
        return outpostService.getOutpostCarMaintainers(outpostId, carId);
    }

}
