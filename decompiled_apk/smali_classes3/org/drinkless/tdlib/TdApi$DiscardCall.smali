.class public Lorg/drinkless/tdlib/TdApi$DiscardCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DiscardCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5c25d572


# instance fields
.field public callId:I

.field public connectionId:J

.field public duration:I

.field public inviteLink:Ljava/lang/String;

.field public isDisconnected:Z

.field public isVideo:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 49590
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49591
    return-void
.end method

.method public constructor <init>(IZLjava/lang/String;IZJ)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "z8"    # Z
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "i10"    # I
    .param p5, "z9"    # Z
    .param p6, "j5"    # J

    .line 49576
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 49577
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->callId:I

    .line 49578
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->isDisconnected:Z

    .line 49579
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->inviteLink:Ljava/lang/String;

    .line 49580
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->duration:I

    .line 49581
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->isVideo:Z

    .line 49582
    iput-wide p6, p0, Lorg/drinkless/tdlib/TdApi$DiscardCall;->connectionId:J

    .line 49583
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 49587
    const v0, -0x5c25d572

    return v0
.end method
