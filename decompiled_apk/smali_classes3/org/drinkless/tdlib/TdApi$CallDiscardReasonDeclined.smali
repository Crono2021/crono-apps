.class public Lorg/drinkless/tdlib/TdApi$CallDiscardReasonDeclined;
.super Lorg/drinkless/tdlib/TdApi$CallDiscardReason;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallDiscardReasonDeclined"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x671c93ce


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 580
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallDiscardReason;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 585
    const v0, -0x671c93ce

    return v0
.end method
