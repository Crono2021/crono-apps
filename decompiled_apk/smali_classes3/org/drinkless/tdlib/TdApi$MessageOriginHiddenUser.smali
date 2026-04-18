.class public Lorg/drinkless/tdlib/TdApi$MessageOriginHiddenUser;
.super Lorg/drinkless/tdlib/TdApi$MessageOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageOriginHiddenUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x12f3dc26


# instance fields
.field public senderName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16548
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageOrigin;-><init>()V

    .line 16549
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16539
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageOrigin;-><init>()V

    .line 16540
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageOriginHiddenUser;->senderName:Ljava/lang/String;

    .line 16541
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16545
    const v0, -0x12f3dc26

    return v0
.end method
