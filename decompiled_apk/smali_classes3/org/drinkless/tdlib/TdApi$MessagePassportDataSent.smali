.class public Lorg/drinkless/tdlib/TdApi$MessagePassportDataSent;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessagePassportDataSent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3ca45ef3


# instance fields
.field public types:[Lorg/drinkless/tdlib/TdApi$PassportElementType;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16602
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16603
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PassportElementType;)V
    .locals 0
    .param p1, "passportElementTypeArr"    # [Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 16593
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16594
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessagePassportDataSent;->types:[Lorg/drinkless/tdlib/TdApi$PassportElementType;

    .line 16595
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16599
    const v0, 0x3ca45ef3

    return v0
.end method
