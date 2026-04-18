.class public Lorg/drinkless/tdlib/TdApi$PageBlockCover;
.super Lorg/drinkless/tdlib/TdApi$PageBlock;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageBlockCover"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39f23300


# instance fields
.field public cover:Lorg/drinkless/tdlib/TdApi$PageBlock;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17160
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17161
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PageBlock;)V
    .locals 0
    .param p1, "pageBlock"    # Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 17151
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PageBlock;-><init>()V

    .line 17152
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PageBlockCover;->cover:Lorg/drinkless/tdlib/TdApi$PageBlock;

    .line 17153
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17157
    const v0, 0x39f23300

    return v0
.end method
