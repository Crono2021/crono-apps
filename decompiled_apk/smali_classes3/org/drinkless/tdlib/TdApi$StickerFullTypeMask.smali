.class public Lorg/drinkless/tdlib/TdApi$StickerFullTypeMask;
.super Lorg/drinkless/tdlib/TdApi$StickerFullType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StickerFullTypeMask"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x26dfbf37


# instance fields
.field public maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 20275
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$MaskPosition;)V
    .locals 0
    .param p1, "maskPosition"    # Lorg/drinkless/tdlib/TdApi$MaskPosition;

    .line 20265
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StickerFullType;-><init>()V

    .line 20266
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StickerFullTypeMask;->maskPosition:Lorg/drinkless/tdlib/TdApi$MaskPosition;

    .line 20267
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20271
    const v0, 0x26dfbf37

    return v0
.end method
