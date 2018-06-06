export class ListElement {
  showHome = true;
  showAbout: boolean;
  showWorking: boolean;
  showApplication: boolean;
  showFaq: boolean;
  showContact: boolean;
  displayHome() {
    this.displayNone();
    this.showHome = !this.showHome;
  }
  displayAbout() {
    this.displayNone();
    this.showAbout = !this.showAbout;
  }
  displayWorking() {
    this.displayNone();
    this.showWorking = !this.showWorking;
  }
  displayApplication() {
    this.displayNone();
    this.showApplication = !this.showApplication;
  }
  displayFaq() {
    this.displayNone();
    this.showFaq = !this.showFaq;
  }
  displayContact() {
    this.displayNone();
    this.showContact = !this.showContact;
  }
  displayNone() {
    this.showHome = false;
    this.showAbout = false;
    this.showWorking = false;
    this.showApplication = false;
    this.showFaq = false;
    this.showContact = false;
  }
}
