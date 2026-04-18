.class public Lorg/drinkless/tdlib/TdApi$BusinessMessages;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BusinessMessages"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2d924c29


# instance fields
.field public messages:[Lorg/drinkless/tdlib/TdApi$BusinessMessage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9240
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9241
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$BusinessMessage;)V
    .locals 0
    .param p1, "businessMessageArr"    # [Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 9231
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9232
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$BusinessMessages;->messages:[Lorg/drinkless/tdlib/TdApi$BusinessMessage;

    .line 9233
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9237
    const v0, -0x2d924c29

    return v0
.end method
