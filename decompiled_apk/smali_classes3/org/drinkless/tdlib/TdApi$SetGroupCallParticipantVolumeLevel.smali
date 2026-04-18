.class public Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantVolumeLevel;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetGroupCallParticipantVolumeLevel"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x688867d8


# instance fields
.field public groupCallId:I

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public volumeLevel:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40438
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40439
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$MessageSender;I)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "i10"    # I

    .line 40427
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40428
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantVolumeLevel;->groupCallId:I

    .line 40429
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantVolumeLevel;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 40430
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$SetGroupCallParticipantVolumeLevel;->volumeLevel:I

    .line 40431
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40435
    const v0, -0x688867d8    # -8.0002053E-25f

    return v0
.end method
