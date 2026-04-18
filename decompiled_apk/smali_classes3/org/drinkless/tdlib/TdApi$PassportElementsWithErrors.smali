.class public Lorg/drinkless/tdlib/TdApi$PassportElementsWithErrors;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementsWithErrors"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4e0494a4


# instance fields
.field public elements:[Lorg/drinkless/tdlib/TdApi$PassportElement;

.field public errors:[Lorg/drinkless/tdlib/TdApi$PassportElementError;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29205
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$PassportElement;[Lorg/drinkless/tdlib/TdApi$PassportElementError;)V
    .locals 0
    .param p1, "passportElementArr"    # [Lorg/drinkless/tdlib/TdApi$PassportElement;
    .param p2, "passportElementErrorArr"    # [Lorg/drinkless/tdlib/TdApi$PassportElementError;

    .line 29194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 29195
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementsWithErrors;->elements:[Lorg/drinkless/tdlib/TdApi$PassportElement;

    .line 29196
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$PassportElementsWithErrors;->errors:[Lorg/drinkless/tdlib/TdApi$PassportElementError;

    .line 29197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29201
    const v0, 0x4e0494a4    # 5.5608346E8f

    return v0
.end method
