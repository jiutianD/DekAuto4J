public class ShortCutEvent {
    public int command_key_1;
    public int command_key_2;
    public int command_key_3;
    public int command_key_4;

    public final static int
            WINDOWS = 0x020C,
            ENTER = '\n',
            BACK_SPACE = '\b',
            TAB = '\t',
            CANCEL = 0x03,
            CLEAR = 0x0C,
            SHIFT = 0x10,
            CTRL = 0x11,
            ALT = 0x12,
            PAUSE = 0x13,
            CAPS_LOCK = 0x14,
            ESCAPE = 0x1B,
            SPACE = 0x20,
            PAGE_UP = 0x21,
            PAGE_DOWN = 0x22,
            END = 0x23,
            HOME = 0x24,
            PrintScreen = 0x9A;
    public static final int
            A = 0x41,
            B = 0x42,
            C = 0x43,
            D = 0x44,
            E = 0x45,
            F = 0x46,
            G = 0x47,
            H = 0x48,
            I = 0x49,
            J = 0x4A,
            K = 0x4B,
            L = 0x4C,
            M = 0x4D,
            N = 0x4E,
            O = 0x4F,
            P = 0x50,
            Q = 0x51,
            R = 0x52,
            S = 0x53,
            T = 0x54,
            U = 0x55,
            V = 0x56,
            W = 0x57,
            X = 0x58,
            Y = 0x59,
            Z = 0x5A;

    public ShortCutEvent() {
    }

    public ShortCutEvent(int command_key_1) {
        this.command_key_1 = command_key_1;
    }

    public ShortCutEvent(int command_key_1, int command_key_2) {
        this.command_key_1 = command_key_1;
        this.command_key_2 = command_key_2;
    }

    public ShortCutEvent(int command_key_1, int command_key_2, int command_key_3) {
        this.command_key_1 = command_key_1;
        this.command_key_2 = command_key_2;
        this.command_key_3 = command_key_3;
    }

    public ShortCutEvent(int command_key_1, int command_key_2, int command_key_3, int command_key_4) {
        this.command_key_1 = command_key_1;
        this.command_key_2 = command_key_2;
        this.command_key_3 = command_key_3;
        this.command_key_4 = command_key_4;
    }
}
