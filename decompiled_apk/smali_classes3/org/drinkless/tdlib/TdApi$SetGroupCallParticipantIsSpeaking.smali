.class public Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantIsSpeaking;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGroupCallParticipantIsSpeaking"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$MessageSender;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3cc70604


# instance fields
.field public audioSource:I

.field public groupCallId:I

.field public isSpeaking:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40416
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40417
    return-void
.end method

.method public constructor <init>(IIZ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "i10"    # I
    .param p3, "z8"    # Z

    .line 40405
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40406
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantIsSpeaking;->groupCallId:I

    .line 40407
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantIsSpeaking;->audioSource:I

    .line 40408
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantIsSpeaking;->isSpeaking:Z

    .line 40409
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40413
    const v0, -0x3cc70604

    return v0
.end method
