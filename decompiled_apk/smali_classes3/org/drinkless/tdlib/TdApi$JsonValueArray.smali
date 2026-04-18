.class public Lorg/drinkless/tdlib/TdApi$JsonValueArray;
.super Lorg/drinkless/tdlib/TdApi$JsonValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "JsonValueArray"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xaf64c4a


# instance fields
.field public values:[Lorg/drinkless/tdlib/TdApi$JsonValue;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15594
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15595
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$JsonValue;)V
    .locals 0
    .param p1, "jsonValueArr"    # [Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 15585
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$JsonValue;-><init>()V

    .line 15586
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$JsonValueArray;->values:[Lorg/drinkless/tdlib/TdApi$JsonValue;

    .line 15587
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15591
    const v0, -0xaf64c4a

    return v0
.end method
