.class public Lorg/drinkless/tdlib/TdApi$StickerFullTypeRegular;
.super Lorg/drinkless/tdlib/TdApi$StickerFullType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerFullTypeRegular"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7797a109


# instance fields
.field public premiumAnimation:Lorg/drinkless/tdlib/TdApi$File;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20292
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 20293
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$File;)V
    .locals 0
    .param p1, "file"    # Lorg/drinkless/tdlib/TdApi$File;

    .line 20283
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 20284
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StickerFullTypeRegular;->premiumAnimation:Lorg/drinkless/tdlib/TdApi$File;

    .line 20285
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20289
    const v0, -0x7797a109

    return v0
.end method
