package com.controller;

import com.service.AppointmentSlotsService;
import com.service.TijiantaocanService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 手动测试专用 Controller
 * 测试完成后可以直接删除，不影响正式功能。
 */
@RestController
@RequestMapping("/test")
public class TestAppointmentController {

    @Autowired
    private AppointmentSlotsService appointmentSlotsService;

    @Autowired
    private TijiantaocanService tijiantaocanService;

    // 查询剩余名额
    @GetMapping("/remaining")
    public R getRemainingSlots(@RequestParam Long packageId,
                               @RequestParam String date,
                               @RequestParam String timeslot) {
        Integer count = appointmentSlotsService.getRemainingSlots(packageId, date, timeslot);
        return R.ok().put("remaining", count);
    }

    // 扣减名额（预约）
    @PostMapping("/decrease")
    public R decreaseSlots(@RequestParam Long packageId,
                           @RequestParam String date,
                           @RequestParam String timeslot) {
        boolean success = appointmentSlotsService.decreaseRemainingSlots(packageId, date, timeslot);
        return success ? R.ok("扣减成功") : R.error("扣减失败");
    }

    // 恢复名额（取消预约）
    @PostMapping("/increase")
    public R increaseSlots(@RequestParam Long packageId,
                           @RequestParam String date,
                           @RequestParam String timeslot) {
        boolean success = appointmentSlotsService.increaseRemainingSlots(packageId, date, timeslot);
        return success ? R.ok("恢复成功") : R.error("恢复失败");
    }
}
