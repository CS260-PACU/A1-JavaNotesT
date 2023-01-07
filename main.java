package edu.pacificu.cs.cs260;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Main {

  public static void main(String[] args) {
    MemNoteStore memNoteStore = new MemNoteStore();
    Note cNote;

    for (int i = 0; i < 11; ++i) {
      memNoteStore.insert(new Note("msg" + i));
      try {
        sleep(250);
      } catch (InterruptedException e) {
        //throw new RuntimeException(e);
      }
    }

    cNote = memNoteStore.getFirst();
    while (null != cNote) {
      System.out.println(cNote);
      cNote = memNoteStore.getNext();
    }

    ArrayList<Note> ones = memNoteStore.findAll("1");
    for (Note cText : ones) {
      System.out.println(cText);
      cText = new Note("Hi " + cText.getMessage(), cText.getTimestamp());
      memNoteStore.update(cText);
    }
    ones = memNoteStore.findAll("1");
    for (Note cText : ones) {
      System.out.println(cText);
      memNoteStore.update(cText);
    }

  }
}
