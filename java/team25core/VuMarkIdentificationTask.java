package team25core;
<<<<<<< HEAD

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
=======
/*
 * FTC Team 25: Created by Elizabeth Wu on December 09, 2017
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
>>>>>>> elizabeth/jewel-detection
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

<<<<<<< HEAD
public class VuMarkIdentificationTask extends RobotTask
{

    public enum EventKind
    {
=======
public class VuMarkIdentificationTask extends RobotTask {


    public enum EventKind {
>>>>>>> elizabeth/jewel-detection
        LEFT,
        RIGHT,
        CENTER,
        UNKNOWN,
    }

<<<<<<< HEAD
    public enum PollingMode {
        ON,
        OFF,
    }

    public class VuMarkIdentificationEvent extends RobotEvent
    {
=======
    public class VuMarkIdentificationEvent extends RobotEvent {

>>>>>>> elizabeth/jewel-detection
        public EventKind kind;

        public VuMarkIdentificationEvent(RobotTask task, EventKind kind)
        {
            super(task);
            this.kind = kind;
        }
<<<<<<< HEAD
=======

>>>>>>> elizabeth/jewel-detection
        public String toString()
        {
            return kind.toString();
        }
    }

    protected VuforiaLocalizerCustom vuforia;
    protected VuforiaTrackable relicTemplate;
    protected Telemetry.Item vuMarkTelemetry;
<<<<<<< HEAD
    protected ElapsedTime pollTimer;
    protected PollingMode pollingMode;
    protected VuforiaBase vuforiaBase;

    protected final static int POLL_RATE = 2;

    public VuMarkIdentificationTask(Robot robot, VuforiaBase vuforiaBase)
    {
        super(robot);
        this.vuMarkTelemetry = robot.telemetry.addData("VuMark: ", "Not Visible");
        this.pollingMode = PollingMode.OFF;
        this.vuforiaBase = vuforiaBase;
=======

    public VuMarkIdentificationTask(Robot robot) {
        super(robot);
        this.vuMarkTelemetry = robot.telemetry.addData("Vumark: ", "Not Visible");
    }

    public VuMarkIdentificationTask(Robot robot, VuforiaLocalizerCustom vuforia)
    {
        super(robot);
        this.vuforia = vuforia;
        this.vuMarkTelemetry = robot.telemetry.addData("Vumark: ", "Not Visible");
>>>>>>> elizabeth/jewel-detection
    }

    @Override
    public void start()
    {
<<<<<<< HEAD
        vuforia = vuforiaBase.getVuforia();

=======
>>>>>>> elizabeth/jewel-detection
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);

        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary
        relicTrackables.activate();
<<<<<<< HEAD
    }

    @Override
    public void stop()
    {
    }

    public void setPollingMode(PollingMode pollingMode)
    {
        this.pollingMode = pollingMode;

        if (pollingMode == PollingMode.ON) {
            pollTimer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
        }
=======

    }

    @Override
    public void stop() {

>>>>>>> elizabeth/jewel-detection
    }

    @Override
    public boolean timeslice()
    {
<<<<<<< HEAD
        if ((pollingMode == PollingMode.ON) && (pollTimer.time() > POLL_RATE)) {
            pollTimer.reset();
            return false;
        }

=======
>>>>>>> elizabeth/jewel-detection
        /**
         * See if any of the instances of {@link relicTemplate} are currently visible.
         * {@link RelicRecoveryVuMark} is an enum which can have the following values:
         * UNKNOWN, LEFT, CENTER, and RIGHT. When a VuMark is visible, something other than
         * UNKNOWN will be returned by {@link RelicRecoveryVuMark#from(VuforiaTrackable)}.
         */
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
<<<<<<< HEAD
        switch (vuMark) {
            case UNKNOWN:
                robot.queueEvent(new VuMarkIdentificationEvent(this, EventKind.UNKNOWN));
                break;
            case LEFT:
                robot.queueEvent(new VuMarkIdentificationEvent(this, EventKind.LEFT));
                break;
            case CENTER:
                robot.queueEvent(new VuMarkIdentificationEvent(this, EventKind.CENTER));
                break;
            case RIGHT:
                robot.queueEvent(new VuMarkIdentificationEvent(this, EventKind.RIGHT));
                break;
        }
        vuMarkTelemetry.setValue("%s visible", vuMark.toString());

        return false;
=======
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
           // vuMarkTelemetry.addData("VuMark", "%s visible", vuMark);

            vuMarkTelemetry.setValue("VuMark: %s visible", vuMark.toString());
            return false;

        }

        else {
            vuMarkTelemetry.setValue("VuMark: not visible");

        }



        return false;

>>>>>>> elizabeth/jewel-detection
    }
}
