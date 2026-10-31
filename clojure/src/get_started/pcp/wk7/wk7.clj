(def teams ["Team A" "Team B" "Team C"])
  
(for [team1 teams
      team2 teams
  :while (not= team1 team2)]
  [team1 team2])