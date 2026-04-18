.class public Lorg/drinkless/tdlib/TdApi$DeleteLanguagePack;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteLanguagePack"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7db123c2


# instance fields
.field public languagePackId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11310
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11311
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11301
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11302
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteLanguagePack;->languagePackId:Ljava/lang/String;

    .line 11303
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11307
    const v0, -0x7db123c2

    return v0
.end method
