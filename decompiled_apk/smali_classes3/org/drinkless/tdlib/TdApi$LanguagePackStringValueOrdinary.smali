.class public Lorg/drinkless/tdlib/TdApi$LanguagePackStringValueOrdinary;
.super Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LanguagePackStringValueOrdinary"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xedb59a0


# instance fields
.field public value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15702
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;-><init>()V

    .line 15703
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15693
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValue;-><init>()V

    .line 15694
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LanguagePackStringValueOrdinary;->value:Ljava/lang/String;

    .line 15695
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15699
    const v0, -0xedb59a0

    return v0
.end method
