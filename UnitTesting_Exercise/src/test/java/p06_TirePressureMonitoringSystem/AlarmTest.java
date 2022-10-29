package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AlarmTest {

    @Test
    public void alarmOnLowPressure() {
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(12.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmOnHighPressure(){
        Sensor sensor = Mockito.mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(30.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmOffNormalPressure(){
        Sensor sensor = mock(Sensor.class);
        when(sensor.popNextPressurePsiValue()).thenReturn(19.0);
        Alarm alarm = new Alarm(sensor);
        alarm.check();

        assertFalse(alarm.getAlarmOn());
    }
}