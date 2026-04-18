.class public Lorg/drinkless/tdlib/TdApi$PaidReactor;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PaidReactor"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x62c86ff8


# instance fields
.field public isAnonymous:Z

.field public isMe:Z

.field public isTop:Z

.field public senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

.field public starCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 48320
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48321
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MessageSender;IZZZ)V
    .locals 0
    .param p1, "messageSender"    # Lorg/drinkless/tdlib/TdApi$MessageSender;
    .param p2, "i9"    # I
    .param p3, "z8"    # Z
    .param p4, "z9"    # Z
    .param p5, "z10"    # Z

    .line 48307
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 48308
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PaidReactor;->senderId:Lorg/drinkless/tdlib/TdApi$MessageSender;

    .line 48309
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$PaidReactor;->starCount:I

    .line 48310
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$PaidReactor;->isTop:Z

    .line 48311
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$PaidReactor;->isMe:Z

    .line 48312
    iput-boolean p5, p0, Lorg/drinkless/tdlib/TdApi$PaidReactor;->isAnonymous:Z

    .line 48313
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 48317
    const v0, -0x62c86ff8

    return v0
.end method
