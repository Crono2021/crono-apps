.class public Lorg/drinkless/tdlib/TdApi$UpdateNewCustomEvent;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewCustomEvent"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x76dd6a0c


# instance fields
.field public event:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21872
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21873
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 21863
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21864
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewCustomEvent;->event:Ljava/lang/String;

    .line 21865
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21869
    const v0, 0x76dd6a0c

    return v0
.end method
