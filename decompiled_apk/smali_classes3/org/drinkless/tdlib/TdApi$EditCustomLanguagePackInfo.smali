.class public Lorg/drinkless/tdlib/TdApi$EditCustomLanguagePackInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditCustomLanguagePackInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4eb91099


# instance fields
.field public info:Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11599
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;)V
    .locals 0
    .param p1, "languagePackInfo"    # Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

    .line 11589
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11590
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditCustomLanguagePackInfo;->info:Lorg/drinkless/tdlib/TdApi$LanguagePackInfo;

    .line 11591
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11595
    const v0, 0x4eb91099

    return v0
.end method
