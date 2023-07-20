import { TestBed } from '@angular/core/testing';

import { TopJobsGuard } from './top-jobs.guard';

describe('TopJobsGuard', () => {
  let guard: TopJobsGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(TopJobsGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
