.class public Lorg/drinkless/tdlib/TdApi$TextParseModeMarkdown;
.super Lorg/drinkless/tdlib/TdApi$TextParseMode;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TextParseModeMarkdown"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x157648bf


# instance fields
.field public version:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextParseMode;-><init>()V

    .line 21315
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 21305
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$TextParseMode;-><init>()V

    .line 21306
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$TextParseModeMarkdown;->version:I

    .line 21307
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21311
    const v0, 0x157648bf

    return v0
.end method
