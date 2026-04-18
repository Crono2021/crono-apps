.class public Lorg/drinkless/tdlib/TdApi$CustomRequestResult;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CustomRequestResult"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x77cd9004


# instance fields
.field public result:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11149
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11139
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11140
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CustomRequestResult;->result:Ljava/lang/String;

    .line 11141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11145
    const v0, -0x77cd9004

    return v0
.end method
