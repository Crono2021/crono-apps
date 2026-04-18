.class public Lorg/drinkless/tdlib/TdApi$AllowUnpaidMessagesFromUser;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AllowUnpaidMessagesFromUser"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x2fe57f57


# instance fields
.field public refundPayments:Z

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22824
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22825
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 22814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 22815
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$AllowUnpaidMessagesFromUser;->userId:J

    .line 22816
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$AllowUnpaidMessagesFromUser;->refundPayments:Z

    .line 22817
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22821
    const v0, 0x2fe57f57

    return v0
.end method
