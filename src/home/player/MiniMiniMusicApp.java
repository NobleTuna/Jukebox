package home.player;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

	public static void main(String[] args) {
		MiniMiniMusicApp mini = new MiniMiniMusicApp();
		mini.play();
		System.out.println("not loof");
	}

	public void play() {

		try {
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			Sequence seq = new Sequence(Sequence.PPQ, 4);

			Track track = seq.createTrack();

			ShortMessage a = new ShortMessage();
			// setMessage(메시지 유형,채널,연주할 음,속도)
			// 메시지 유형 : 연주 시작
			// 채널 : 악기
			// 연주할 음 : 음계
			// 속도(건반 타건 세기) : 보통 100이 기본
			a.setMessage(144, 1, 44, 100);
			MidiEvent noteOn = new MidiEvent(a, 1);
			track.add(noteOn);

			ShortMessage b = new ShortMessage();
			b.setMessage(128, 1, 44, 100);
			b.setMessage(192, 1, 102, 100);
			MidiEvent noteOff = new MidiEvent(b, 16);
			track.add(noteOff);

			player.setSequence(seq);

			player.start();

		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
		}

	}

}
