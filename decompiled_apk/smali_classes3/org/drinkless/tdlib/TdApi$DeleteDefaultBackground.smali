.class public Lorg/drinkless/tdlib/TdApi$DeleteDefaultBackground;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteDefaultBackground"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4d5b12c2


# instance fields
.field public forDarkTheme:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11275
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 11265
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11266
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteDefaultBackground;->forDarkTheme:Z

    .line 11267
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11271
    const v0, -0x4d5b12c2    # -1.9199998E-8f

    return v0
.end method
