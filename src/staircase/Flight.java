package staircase;

import java.util.ArrayList;
import java.util.List;

public class Flight {
	public double rise = 0;
	public double run = 0;

	public boolean includeTopStep = true;
	public List<Step> steps = new ArrayList<>();
	public Landing landing = new Landing();
	public Banister banister = new Banister();

	public NewelPost newelPost = new NewelPost();
	public Boolean useBalusters = true;
	public Balusters balusters = new Balusters();
	public Boolean useBaseRail = true;
	public Baserail baserail = new Baserail();
	public Boolean useRails = false;
	public Rails rails = new Rails();

	public Boolean useInnerString = true;
	public StringerInner innerString = new StringerInner();
	public Boolean useOuterString = true;
	public StringerOuter outerString = new StringerOuter();
	public Boolean useUnderString = true;
	public List<StringerUnder> understrings = new ArrayList<>();
}