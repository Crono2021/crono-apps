.class public Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetStoryInteractions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$StoryInteractions;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1cd1400d


# instance fields
.field public limit:I

.field public offset:Ljava/lang/String;

.field public onlyContacts:Z

.field public preferForwards:Z

.field public preferWithReaction:Z

.field public query:Ljava/lang/String;

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51344
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51345
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;ZZZLjava/lang/String;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z
    .param p6, "str2"    # Ljava/lang/String;
    .param p7, "i10"    # I

    .line 51329
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 51330
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->storyId:I

    .line 51331
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->query:Ljava/lang/String;

    .line 51332
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->onlyContacts:Z

    .line 51333
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->preferForwards:Z

    .line 51334
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->preferWithReaction:Z

    .line 51335
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->offset:Ljava/lang/String;

    .line 51336
    iput p7, p0, Lorg/drinkless/tdlib/TdApi$GetStoryInteractions;->limit:I

    .line 51337
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51341
    const v0, 0x1cd1400d

    return v0
.end method
