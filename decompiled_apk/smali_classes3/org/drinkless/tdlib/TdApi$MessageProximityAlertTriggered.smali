.class public Lorg/drinkless/tdlib/TdApi$MessageProximityAlertTriggered;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageProximityAlertTriggered"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x409f6d3


# instance fields
.field public distance:I

.field public travelerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public watcherId:Lorg/drinkless/tdlib/TdApi$MessageSender;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38612
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38613
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;Lorg/drinkless/tdlib/TdApi$MessageSender;I)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "messageSender2"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p3, "i9"    # I

    .line 38601
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38602
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageProximityAlertTriggered;->travelerId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 38603
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageProximityAlertTriggered;->watcherId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 38604
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$MessageProximityAlertTriggered;->distance:I

    .line 38605
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38609
    const v0, 0x409f6d3

    return v0
.end method
