namespace java tutorial

typedef i32 int

 struct SpellRequest {

  1: list<string> to_check

}

 

struct SpellResponse {

  1: list<bool> is_correct

}

 

service SpellService {

  SpellResponse spellcheck(1:SpellRequest request)

}