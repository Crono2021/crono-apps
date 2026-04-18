.class public Lorg/drinkless/tdlib/TdApi$SetGameScore;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGameScore"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Message;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7eccedc6


# instance fields
.field public chatId:J

.field public editMessage:Z

.field public force:Z

.field public messageId:J

.field public score:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50766
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50767
    return-void
.end method

.method public constructor <init>(JJZJIZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "z8"    # Z
    .param p6, "j10"    # J
    .param p8, "i9"    # I
    .param p9, "z9"    # Z

    .line 50752
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 50753
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->chatId:J

    .line 50754
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->messageId:J

    .line 50755
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->editMessage:Z

    .line 50756
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->userId:J

    .line 50757
    iput p8, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->score:I

    .line 50758
    iput-boolean p9, p0, Lorg/drinkless/tdlib/TdApi$SetGameScore;->force:Z

    .line 50759
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50763
    const v0, 0x7eccedc6

    return v0
.end method
