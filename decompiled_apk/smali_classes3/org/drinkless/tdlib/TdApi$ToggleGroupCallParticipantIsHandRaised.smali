.class public Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsHandRaised;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGroupCallParticipantIsHandRaised"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x71049c1f


# instance fields
.field public groupCallId:I

.field public isHandRaised:Z

.field public participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41165
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$MessageSender;Z)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "z8"    # Z

    .line 41153
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 41154
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsHandRaised;->groupCallId:I

    .line 41155
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsHandRaised;->participantId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 41156
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$ToggleGroupCallParticipantIsHandRaised;->isHandRaised:Z

    .line 41157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41161
    const v0, -0x71049c1f

    return v0
.end method
