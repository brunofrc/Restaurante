import { CredoClientPage } from './app.po';

describe('credo-client App', function() {
  let page: CredoClientPage;

  beforeEach(() => {
    page = new CredoClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
