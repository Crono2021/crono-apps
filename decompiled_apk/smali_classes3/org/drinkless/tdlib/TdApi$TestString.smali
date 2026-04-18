.class public Lorg/drinkless/tdlib/TdApi$TestString;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "TestString"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1a99774


# instance fields
.field public value:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21098
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21099
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 21089
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 21090
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$TestString;->value:Ljava/lang/String;

    .line 21091
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21095
    const v0, -0x1a99774

    return v0
.end method
