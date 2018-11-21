package team25core;
<<<<<<< HEAD
/*
 * FTC Team 25: Created by Elizabeth Wu on December 09, 2017
 */
=======
>>>>>>> upstream/master

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

public class VuMarkIdentificationTask extends RobotTask
{

    public enum EventKind
    {
        LEFT,
        RIGHT,
        CENTER,
        UNKNOWN,
    }

    public enum PollingMode {
        ON,
        OFF,
    }

    public class VuMarkIdentificationEvent extends RobotEvent
    {
        public EventKind kind;

        public VuMarkIdentificationEvent(RobotTask task, EventKind kind)
        {
            super(task);
            this.kind = kind;
        }
        public String toString()
        {
            return kind.toString();
        }
    }

    protected VuforiaLocalizerCustom vuforia;
    protected VuforiaTrackable relicTemplate;
    protected Telemetry.Item vuMarkTelemetry;
    protected ElapsedTime pollTimer;
    protected PollingMode pollingMode;
<<<<<<< HEAD
    protected RelicRecoveryVuMark glyphPosition;

    protected final static int POLL_RATE = 1;

    public VuMarkIdentificationTask(Robot robot)
    {
        super(robot);
        this.vuMarkTelemetry = robot.telemetry.addData("Vumark: ", "Not Visible");
        this.pollingMode = PollingMode.OFF;
    }

    public VuMarkIdentificationTask(Robot robot, VuforiaLocalizerCustom vuforia)
    {
        super(robot);
        this.vuforia = vuforia;
        this.vuMarkTelemetry = robot.telemetry.addData("Vumark: ", "Not Visible");
        this.pollingMode = PollingMode.OFF;
=======
    protected VuforiaBase vuforiaBase;

    protected final static int POLL_RATE = 2;

    public VuMarkIdentificationTask(Robot robot, VuforiaBase vuforiaBase)
    {
        super(robot);
        this.vuMarkTelemetry = robot.telemetry.addData("VuMark: ", "Not Visible");
        this.pollingMode = PollingMode.OFF;
        this.vuforiaBase = vuforiaBase;
>>>>>>> upstream/master
    }

    @Override
    public void start()
    {
<<<<<<< HEAD
=======
        vuforia = vuforiaBase.getVuforia();

>>>>>>> upstream/master
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);

        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary
        relicTrackables.activate();
    }

    @Override
    public void stop()
    {
<<<<<<< HEAD

=======
>>>>>>> upstream/master
    }

    public void setPollingMode(PollingMode pollingMode)
    {
        this.pollingMode = pollingMode;

        if (pollingMode == PollingMode.ON) {
            pollTimer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
        }
    }

<<<<<<< HEAD
    public RelicRecoveryVuMark getGlyphPosition() {

        return this.glyphPosition;
    }

=======
>>>>>>> upstream/master
    @Override
    public boolean timeslice()
    {
        if ((pollingMode == PollingMode.ON) && (pollTimer.time() > POLL_RATE)) {
<<<<<<< HEAD
            vuforia.forceRefreshBitmap();
            pollTimer.reset();
            return false;
        }
=======
            pollTimer.reset();
            return false;
        }

>>>>>>> upstream/master
        /**
         * See if any of the instances of {@link relicTemplate} are currently visible.
         * {@link RelicRecoveryVuMark} is an enum which can have the following values:
         * UNKNOWN, LEFT, CENTER, and RIGHT. When a VuMark is visible, something other than
         * UNKNOWN will be returned by {@link RelicRecoveryVuMark#from(VuforiaTrackable)}.
         */
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
<<<<<<< HEAD
        if (vuMark != RelicRecoveryVuMark.UNKNOWN) {
           // vuMarkTelemetry.addData("VuMark", "%s visible", vuMark);
            vuMarkTelemetry.setValue("VuMark: %s visible", vuMark.toString());
            glyphPosition = vuMark;
            return false;
        } else {
            vuMarkTelemetry.setValue("VuMark: not visible");
        }
=======
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
>>>>>>> upstream/master

        return false;
    }
}
