.class public Lorg/drinkless/tdlib/TdApi$PassportElementTypeAddress;
.super Lorg/drinkless/tdlib/TdApi$PassportElementType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementTypeAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d955cc2


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4672
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElementType;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4677
    const v0, 0x1d955cc2

    return v0
.end method
