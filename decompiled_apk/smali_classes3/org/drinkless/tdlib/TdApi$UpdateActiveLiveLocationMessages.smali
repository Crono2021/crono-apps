.class public Lorg/drinkless/tdlib/TdApi$UpdateActiveLiveLocationMessages;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateActiveLiveLocationMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4df8ab68


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$Message;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21476
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21477
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "messageArr"    # [Lorg/drinkless/tdlib/TdApi$Message;

    .line 21467
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21468
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateActiveLiveLocationMessages;->messages:[Lorg/drinkless/tdlib/TdApi$Message;

    .line 21469
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21473
    const v0, -0x4df8ab68

    return v0
.end method
