.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementEmailAddress;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementEmailAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xed16bdb


# instance fields
.field public emailAddress:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14838
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14839
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14829
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14830
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementEmailAddress;->emailAddress:Ljava/lang/String;

    .line 14831
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14835
    const v0, -0xed16bdb

    return v0
.end method
