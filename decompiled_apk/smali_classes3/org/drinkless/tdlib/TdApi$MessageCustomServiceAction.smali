.class public Lorg/drinkless/tdlib/TdApi$MessageCustomServiceAction;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageCustomServiceAction"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5595c772


# instance fields
.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16404
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16405
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16395
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16396
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageCustomServiceAction;->text:Ljava/lang/String;

    .line 16397
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16401
    const v0, 0x5595c772

    return v0
.end method
