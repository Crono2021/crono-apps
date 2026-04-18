.class public Lorg/drinkless/tdlib/TdApi$DeleteMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x435bcebd


# instance fields
.field public chatId:J

.field public messageIds:[J

.field public revoke:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36608
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36609
    return-void
.end method

.method public constructor <init>(J[JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "jArr"    # [J
    .param p4, "z8"    # Z

    .line 36597
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 36598
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteMessages;->chatId:J

    .line 36599
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$DeleteMessages;->messageIds:[J

    .line 36600
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$DeleteMessages;->revoke:Z

    .line 36601
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36605
    const v0, 0x435bcebd

    return v0
.end method
